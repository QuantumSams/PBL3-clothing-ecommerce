package Model.DAL.Repository;

import java.util.List;

import Model.DAL.Specification.Specification;

public interface RemoveRepository<T> {
	void removeBySpacification(Specification<T> specification);
}
