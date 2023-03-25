class N392_IsSubsequence{
	public boolean isSubsequence(String s,String t){
		if(s.length() == 0){
			return true;
		}
		else if(s.length() > t.length()){
			return false;
		}
		int i_s = 0;
		int i_t = 0;
		while(i_t < t.length()){
			if(s.charAt(i_s) == t.charAt(i_t)){
				i_s++;
				i_t++;
				if(i_s >= s.length()){
					return true;
				}
			}
			else{
				i_t++;
			}
		}
		return false;
	}
}
