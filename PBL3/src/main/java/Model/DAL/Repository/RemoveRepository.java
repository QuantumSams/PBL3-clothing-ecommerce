package Model.DAL.Repository;

import Model.DAL.Specification.Specification;

public interface RemoveRepository<T> {
	void removeBySpacification(Specification<T> specification);
}
