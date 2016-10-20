package OpenX;

public class SubString {

	 String in ;

	 void substrings(String str)
	
	{
	 int start = 0;
	 int end = 1;
	 in = str;
	 substrings(start,end);
	}
	 void substrings(int start, int end){
	    if(start == in.length() && end == in.length()){
	        return;
	    }else{
	        if(end == in.length()+1){
	            substrings(start+1,start+1);
	        }else{
	            System.out.println(in.substring(start, end));
	            substrings(start, end+1);
	        }
	    }
	}	
	 
		public void nonrecursive(String d)
		{
			for(int i =0 ; i<d.length();i++)
			{
				for( int j = i + 1 ; j<=d.length();j++)
				{
					System.out.println(d.substring(i,j));
				}
			}
		}
	 
	 public static void main(String[] args)
	 {
		 SubString s = new SubString();
		 s.substrings("abc");
	 }
	
}
