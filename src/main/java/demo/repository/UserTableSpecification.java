package demo.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.LocalDate;
import org.springframework.data.jpa.domain.Specification;

import demo.model.Usertable;

public class UserTableSpecification {
	
	
	public static Specification<Usertable> accountExpiresBefore(final LocalDate date) {

		return new Specification<Usertable>() {

			@Override
			public Predicate toPredicate(Root<Usertable> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Root<Usertable> accounts = query.from(Usertable.class);
				//Path<Date> expiryDate = accounts.<Date> get("expiryDate");
				Predicate customerIsAccountOwner = cb.equal(accounts.<Usertable> get("userid"), root);
			//	Predicate accountExpiryDateBefore = cb.lessThan(expiryDate, date.toDateTimeAtStartOfDay().toDate());

				return cb.and(customerIsAccountOwner);//, accountExpiryDateBefore);
			}
		};
	}
//
//	private final Usertable example;
//
//	  public UserTableSpecification(Usertable example) {
//	    this.example = example;
//	  }
//	  
//	  
//	  @PersistenceContext private EntityManager entityManagerFactory;
//
//	//@Transactional
//	@Override
//	public Predicate toPredicate(Root<Usertable> root, CriteriaQuery<?> cq,
//			CriteriaBuilder cb) {
//		// TODO Auto-generated method stub
//		 List<Predicate> predicates = new ArrayList<>();
//		 Metamodel m = entityManagerFactory.getMetamodel();
//		 EntityType<Usertable> Pet_ = m.entity(Usertable.class);
//		 CriteriaQuery<Usertable> cq1 = cb.createQuery(Usertable.class);
//		 Root<Usertable> pet = cq1.from(Usertable.class);
//		 Predicate predicate = cb.like(pet.<String>get(Pet_.getName()),"*dri");
//		 //cq.where(cb.like(pet.get(Pet_.getName())), "*do");
//		predicates.add(predicate);
//		 
//		 return andTogether(predicates, cb);
//		//return null;
//	}
//	
//	 private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
//		    return cb.and(predicates.toArray(new Predicate[0]));
//		  }
//	
//
////	public static Specification<Usertable> customerHasBirthday() {
////	    return new Specification<Usertable> {
////	      public Predicate toPredicate(Root<T> root, CriteriaQuery query, CriteriaBuilder cb) {
////	       // return cb.equal(root.get(Customer_.birthday), today);
////	      }
////	    };
////	  }
////
////	  public static Specification<Usertable> isLongTermCustomer() {
////	    return new Specification<Usertable> {
//////	      public Predicate toPredicate(Root<T> root, CriteriaQuery query, CriteriaBuilder cb) {
//////	        return cb.lessThan(root.get(Customer_.createdAt), new LocalDate.minusYears(2));
//////	      }
////	    };
////	  }
//	

//	@Override
//	public Predicate toPredicate(Root<Usertable> arg0, CriteriaQuery<?> arg1,
//			CriteriaBuilder arg2) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
