public class Name {
	NameExpressions expression;
	Name root;//ex: Elephant is Animal
	Fact[] properties;//ex: [Be Vegetarian, Have Long Nose]
	public boolean equal(Name other){
		if(expression==other.expression) return(true);
		if(this.is(other)&&other.is(this)) return(true);
		
		return(false);
	}
	private protected Name[] children(){
		/*get descendance of this name. ex: Hourse, Elephant... are descendant from Animal*/
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
