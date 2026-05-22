package com.florista.florista.repository;

import com.florista.florista.model.Gardener;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GardenerRepository extends JpaRepository<Gardener, Long> {
}
