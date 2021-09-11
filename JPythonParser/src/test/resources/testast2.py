import numpy as np
D = np.clip(D, 0, 1)
a = D * XYZ_w[..., 1] / XYZ_wr[..., 1]