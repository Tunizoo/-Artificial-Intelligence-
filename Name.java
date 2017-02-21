public class Name {
	boolean type;//single like "elepehant" / compound as "white elephant" or "eye of elephant"
	Name root;//ex: Elephant is Animal
	Name[] adjectives;//Adjectives that serve to define the name
			//Ex: 
			//to define an elephant (simple name)
			//Vegetarian (Elephant is Animal which is Vegetarian)
			//to define "Grey Elephant Of Asia"
			//root:Elephant, adjectives:[Grey,[Of Asia]]
	Fact[] properties;//ex: has a long nos
	public boolean equal(Name other){
		//this function is useful when returns 'true' (in 'if' statemenbts)
		//if it returns 'false', this may not always mean really false
		if(this.getName()==other.getName()) return(true);
		if(this.root.getName()==other.root.getName()){
			boolean find=false;
			for(int i=0;i<this.adjectives.length;i++)
			for(int j=0;j<other.adjectives.length;j++)				
				if(this.adjectives[i].equals(other.adjectives[j])
					find=true;
			if(!find) return(false);
			boolean find=false;
			for(int i=0;i<this.properties.length;i++)
			for(int j=0;j<other.properties.length;j++)				
				if(this.properties[i].equivalent(other.properties[j])
					find=true;
			if(!find) return(false);
		        return true;	
		}	
		return(false);
	}
	public is(Name other){
		Name r=this;
		while(r.root!=null){
			if(r.root.equal(other)) return(true);
			r=r.root;
		}
		if(root.is(other.root))
		{//are the properties of this included in those of other?
			for(short i=0;i<properties.length;i++){
				short j=0;
				while(!properties[i].is(other.properties[j])) j++;
				if(j==other.properties.length) return(false);
			} return(true);
		}	
		return(false);		
	}
	public Name not(){
		//if(expression.charAt(0)=='!')
	}
	public Name and(Name name);
	public Name or(Name name);
	public Name of(Name name);	
}
