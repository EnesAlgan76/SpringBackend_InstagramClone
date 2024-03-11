package com.example.SpringBackend_InstagramClone.utils;

import com.example.SpringBackend_InstagramClone.dto.FilterDTO;
import com.example.SpringBackend_InstagramClone.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification {
    // columnEqual() can be any name you want
    public static Specification<User> columnEqual(List<FilterDTO> filterDTOList) {
        return new Specification<User>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                filterDTOList.forEach(filter -> {
                    Predicate predicate = criteriaBuilder.equal(root.get(filter.getColumnName()), filter.getColumnValue());
                    predicates.add(predicate);
                });

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}