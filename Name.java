import DBaccess;
import ArrayList;
public class Name {
	String id;
	Name[] terms;//for a compound name (ex:Nose Of Elephant)
	Name[] definition;
	//properties that serve to define this name
	//Ex: 
	//Elephant Is Animal
	//Elephant Is Big 
	//(Nose Of Elephant) Is Long
	String expression(String language){
	//expression of this name in a given language
	}
	public void define_redefine(){
	//use properties that may be found in the database
	//to define, or to redefine the name
	//eventually with simplification
    	    ArrayList properties=ArrayList();
	    int i,j;
	    for(i=0;i<definition.length;i++)
		properties.add(definition[i]);
	    Name[] other_props=DBaccess.search(this.id);
	    if(other_props)
		for(i=0;i<other_props.length;i++)
		properties.add(other_props[i]);	
	    for(i=0;i<properties.length;i++)
		for(j=0;j<properties.length;j++){
			if(i==j) continue;
			if(properties[j]==null || properties[i].is(properties[j])){
				int k=j;
				while(k<properties.length)
					properties[k]=properties[++k];
				properties[properties.length-1]=null;//to remove last element below
			}
		}	
		//New array with some elements removed:
		i=0;while(properties[i]!=null) i++;//count elements
		Fact[] props=new Fact[i];//new temporary array
		j=0;while(j<i) props[j]=properties[j++];//assign properties elements to temporary array
		properties=props;//new array assigned to this.properties
	}
	public Name(String identifier){
		String[] row=DBaccess.search(identifier,null,null);
		if (row) {
			this.id=row[0];
			if(row.length>1)
			this.definition=new Name(row.length-1);
			for(int i=0;i<props.length;i++)
				this.definition[i]=Name(row[i-1]);
		} else {
			Name N=new Name;
			N.id=identifier;
			N.DBaccess.put();
			return(N);
		}
	}
	public Name(Name[] terms){
		this.id="_";
		this.terms=terms;
		this.define_redefine();
		for(int i=0;i<props.length;i++){
			this.id+=props[i].id[0];
			if(props[i].id.length>1) this.id+=props[i].charAt(1);
			else this.id+="-";
			if(props[i].id.length>2) this.id+=props[i].charAt(2);
			else this.id+="-";
			if(props[i].id.length>3) this.id+=props[i].charAt(3);
			else this.id+="-";
			this.id+="";
		}
	}
	public boolean equal(Name other){
		//this function is useful only when returns 'true' (in 'if' statements)
		//if it returns 'false', this may not always mean really false
		if(this.id==other.id) return(true);
		boolean compare=true;
		for(int i=0;i<this.terms.length;i++){		
		    boolean find=false;
		    for(int j=0;j<other.terms.length;j++)				
			if(this.terms[i].equal(other.terms[j])
				{find=true;break;}
		    if(!find) return(false);
		}
		for(int i=0;i<this.definition.length;i++){
		    boolean find=false;
		    for(int j=0;j<other.definition.length;j++)				
			if(this.definition[i].is(other.definition[j])
				{find=true;break;}
		    if(definition[i].is(other.root) find=true;	
		    if(!find) return(false);
		}
	        return true;
	}
	public boolean is(Name other){
		//useful only if true (in if conditions..)
		if(this.equal(other)) return(true);
		Name[] is_in_DB=DBaccess.search(this.id,"Be",other.id);
		if(is_in_DB != null) return(true);
		for(int i=0;i<this.definition.length;i++){
			if(this.definition[i].is(other))
				return(true);
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
