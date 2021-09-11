package org.eclipse.jdt.python.typeinference.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import com.google.gson.Gson;

import org.eclipse.jdt.python.typeinference.antlr.TypeInfo;
import org.eclipse.jdt.python.typeinference.antlr.TypeTree;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.antlr.runtime.RecognitionException;
import org.apache.log4j.Logger;


public class TypeInformation {
    static Logger logger = Logger.getLogger(TypeInformation.class);

    //    static Logger typeLogger = Logger.getLogger("typeerror");
    public Map<TypeASTNode, TypeTree> getTypeTreeInformation(String filePath, String projectPath, String fileName, ArrayList<TypeASTNode> requiredNodes) throws RecognitionException {
        TypeInfo typeInfo = new TypeInfo();
        Map<TypeASTNode, TypeTree> typeASTNodeTypeTreeMap = new HashMap<>();
        Map<TypeASTNode, String> typeInformation = getTypeInformation(filePath, projectPath, fileName);
        for (TypeASTNode requiredNode : requiredNodes) {
            logger.debug("Finding type information of : "+requiredNode.toString());
            String typeString = typeInformation.get(requiredNode);
            typeASTNodeTypeTreeMap.put(requiredNode,typeInfo.getTypeTree(typeString));
        }
        return typeASTNodeTypeTreeMap;
    }


    public Map<TypeASTNode,String> getTypeInformationFromJsonFile(String fileSource ,String projectName, String commitHex, String postfix, String fileName){
        Map<TypeASTNode,String> type_string = new HashMap<>();
        try {
            String json_file = fileSource +"/" +projectName+"/"+ commitHex +   postfix +"/" +  fileName.substring(0,fileName.length()-3) +".json";
            Gson gson = new Gson();

            String s = Files.readString(Path.of(json_file));


            if (s ==null) return null;
            TypeASTNode[] astArray = gson.fromJson(s, TypeASTNode[].class);
            for(TypeASTNode node : astArray) {
                logger.debug(node.toString());
                String type = node.getType();
                node.setType(null);
                type_string.put(node, type);
            }
//            JSONArray a = (JSONArray) parser.parse(new FileReader(json_file));
//            JSONObject o = (JSONObject)a.get(0);

        }
        catch (NoSuchFileException e){
            return null;
        }
        catch (IOException e) {
            return null;
        }


//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        return type_string;

    }

    public Map<TypeASTNode,String> getTypeInformation(String filePath,String project_path,String file_name){
        Map<TypeASTNode,String> type_string = new HashMap<>();
        try {

            Process process = Runtime.getRuntime().exec(Configurations.PYTHON_VIRTUAL_ENVIRONMENT+ " "+
                    System.getProperty("user.dir")+"/src/main/java/python/typeinference/pythonscripts/mainPyTypetest.py " +
                    ""+filePath+" "+project_path+" "+file_name+"/");
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            BufferedReader stdINput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean error = false;
            while ((line = stdError.readLine()) != null) {

                error=true;
            }
            if (error) return null;

            String typeString = getTypeString(stdINput);

            Gson gson = new Gson();
            TypeASTNode[] astArray = gson.fromJson(typeString, TypeASTNode[].class);

            for(TypeASTNode node : astArray) {
                logger.debug(node.toString());
//                System.out.println(node.toString());
                if (type_string.get(node) !=null){
                    logger.error(node + "Node exists");
                }
                String type = node.getType();
                node.setType(null);
                type_string.put(node, type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return type_string;
    }

    private String getTypeString(BufferedReader stdINput) throws IOException {
        String s ;
        String typeString = "";
        while ((s = stdINput.readLine()) != null) {
            logger.info(s);
            typeString=s;
        }
        return typeString;
    }
}
