int _single=0, _compound=1, _name_of_fact=2;//single name like Hourse, compund like "Eye Of Hourse"
public class Name {
	String id;
	Name root;//ex: Elephant is Animal
	Fact[] properties;//Properties that serve to define the name
			//Ex: 
			//to define an elephant (simple name)
			//Elephant Is Vegetarian 
			//Nose Of Elephant Is Long
			//to define "Grey Elephant Of Asia"
			//root:Elephant, properties:[Grey,[Of Asia]]
	private simplify(){
		int i,j;
		for(i=0;i<properties.length;i++)
			for(j=0;j<properties.length;j++){
				if(i==j) continue;
				if(properties[j]==null || properties[j].implies(properties[i])){
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
	private String[] DB_search(String id,String r,String[] props){
		//search in the DB
		//some of the arguments id,r,props may be null
		//returns fields of the line found in the DB
		//otherwise null
	}
	private DB_put(){
		//store this name in the DB
	}
	public Name(String id){
		String[] row=DB_search(id,null,null);
		if (row) {
			this.id=row[0];
			if(row.length>1)
				this.root=Name(row[1]);
			if(row.length>2)
			this.properties=new Name(row.length-2);
			for(int i=0;i<props.length;i++)
				this.properties[i]=Name(row[i-2]);
		} else {
			Name N=new Name;
			N.id=id;
			N.DB_put();
			return(N);
		}
	}
	public Name(Name R,Fact[] props){
		this.root=R;
		this.properties=props;
		this.simplify();
		this.id="";
		for(int i=0;i<props.length;i++){
			this.id+=props[i].id[0];
			if(props[i].id.length>1) this.id+=props[i].charAt(1);
			if(props[i].id.length>2) this.id+=props[i].charAt(2);
			this.id+='_';
		}
	}
	public boolean equal(Name other){
		//this function is useful only when returns 'true' (in 'if' statements)
		//if it returns 'false', this may not always mean really false
		if(this.getName()==other.getName()) return(true);
		if(this.root.not().is(other.root) || other.root.not().is(this.root))
			return(false);
		for(int i=0;i<this.properties.length;i++){
		    boolean find=false;
		    for(int j=0;j<other.properties.length;j++)				
			if(this.properties[i].is(other.properties[j])
				{find=true;break;}
		    if(properties[i].is(other.root) find=true;	
		    if(!find) return(false);
		}
		for(int i=0;i<other.properties.length;i++){
		    boolean find=false;
		    for(int j=0;j<this.properties.length;j++)				
			if(other.properties[i].is(this.properties[j])
				{find=true;break;}
		    if(other.properties[i].is(this.root) find=true;	
		    if(!find) return(false);
		}
	        return true;	//find=true
	}
	public is(Name other){
		//useful only if true (in if conditions..)
		Name r=this;
		while(r.root!=null){
			if(r.root.equal(other)) return(true);
			r=r.root;
		}
		if(root.is(other.root))
		{
		   if(properties.length>=other.properties.length){
			//are the properties of this included in those of other?
			for(int i=0;i<properties.length;i++){
			    boolean find=false;
			    if(properties[i].is(other).root) find=true;
			    else for(int j=0;j<other.properties.length;j+)
				    if(properties[i].is(other.properties[j])) 
					{find=true;break;}
			    if(!find) return(false);
			} return(true);
		   }else return false;
			return(test1 && test2);
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
