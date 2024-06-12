package Model.DAL.Repository;

import Model.DAL.Specification.Specification;

public interface UpdateRepository<T> {
	void updateBySpacification(Specification<T> specification);
}
