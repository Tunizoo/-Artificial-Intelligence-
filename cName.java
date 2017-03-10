public class cName extends Name {
//for "compound" names (ex: Eye Of Cat, Black Cat...
	Name source;
	Relation relation;
	Name destination;
	public cName(Name src,Relation rel,Name dst)
	{
		this.id="_";
		this.source=src;
		this.relation=rel;
		this.destination=dst;
		this.readProperties();
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
}
