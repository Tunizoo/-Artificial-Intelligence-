public class Fact() {
	Name subject;
	Name relation;
	Name object;
	//Ex: Cat(subject) Eat(relation) Mouse (object)
	Fact condition;//condition for the fact to be true (ex: Usual, if Night, etc)
	public Fact not() {return(Fact(subject,relation.not(),object));}
	public Fact and(Fact other){
		if(this.is(other)) return(this);
		else if(other.is(this)) return(other);
		else if(this.not().is(other)||other.not().is(this)) return(FALSE);
		Fact result=new Fact;		
		if(object==null&&other.object==null||object.equal(other.object)) {
			result.object=object;
			if(subject.equal(other.subject)) {
				result.subject=subject;
				result.relation=relation.and(other.relation));
			}
			else if(relation.equal(other.relation)) {
				result.relation=relation;
				result.subject=subject.and(other.subject));
			}
			else {
				result.subject=null;
				result.relation=Name([Name([this.subject,this.relation]),AND,Name([other.subject,other.relation])]);
				result.object=this.object;
			}
		}
		else if(subject==null&&other.subject==null||subject.equal(other.subject)) {
			result.subject=subject;
			if(object.equal(other.object)) {
				result.object=object;
				result.relation=relation.and(other.relation));
			}
			else if(relation.equal(other.relation)) {
				result.relation=relation;
				result.object=object.and(other.object));
			}
			else {
				result.subject=this.subject;
				result.relation=Name([Name([this.relation,this.object]),AND,Name([other.relation,other.object])]);
				result.object=null;
			}
		}
		else {
			result.subject=Name(this);
			result.relation=AND;
			result.object=Name(other);
		}		
	}
	public Fact or(Fact other);

}
