import DBaccess;
public class Fact extands Name {
	Name subject;
	Name relation;
	Name object;
	//Ex: Cat(subject) Eat(relation) Mouse (object)
	public veracity(){
	//When this fact is true?
	//FALSE, rarely, 30%, at night, in China, 50%, frequently, TRUE...
	}
	public Fact not() {return(Fact(subject,relation.not(),object));}
	public Fact and(Fact other){
		if(this.is(other)||other.is(this)) return(this);
		if(this.not().is(other)||other.not().is(this)) return(FALSE);
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
				result.subject=Name(this);
				result.relation=AND;
				result.object=Name(other);
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
				result.subject=Name(this);
				result.relation=AND;
				result.object=Name(other);
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
