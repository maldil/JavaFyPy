public ProgressPanel(SwingSet swing) {
	progressBar = new JProgressBar() {
		public Dimension getPreferredSize() {
			return new Dimension(300, super.getPreferredSize().height);
		}
	};
	progressBar.getAccessibleContext()
			.setAccessibleName("Text loading progress");
}