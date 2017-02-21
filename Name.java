boolean _single=true, _compound=false;//single name like Hourse, compund like "Eye Of Hourse"

public class Name {
	boolean type;//_single / _compound
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
		{
			boolean test1=false,test2=false;
		   if(adjectives.length>=other.adjectives.length){
			//are the adjectives of this included in those of other?
			for(int i=0;i<adjectives.length;i++){
			    for(int j=0;j<other.adjectives.length;j+)
				if(adjectives[i].is(other.adjectives[j])) {test1=true;break;}
			    if(j==other.adjectives.length) return(false);
			}test1=true;
		   }if(properties.length>=other.properties.length){
			//are the properties of this included in those of other?
			for(int i=0;i<properties.length;i++){
			    for(int j=0;j<other.properties.length;j+)
				if(properties[i].is(other.properties[j])) {test1=true;break;}
			    if(j==other.properties.length) return(false);
			} test2=true;
		   }	return(test1 && test2);
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
