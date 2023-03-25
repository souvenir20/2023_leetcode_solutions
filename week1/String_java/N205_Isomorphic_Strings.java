package String;
class N205_Isomorphic_Strings{
	public static boolean isIsomorphic(String s,String t){
		if(s.length() != t.length()){
			return false;
		}
		else if(s.length() == 1){
			return true;
		}
		for(int index = 0;index < s.length();index++){
			if(s.indexOf(s.charAt(index)) != t.indexOf(t.charAt(index))){
				return false;
			}
		}
		return true;
	}	
}
