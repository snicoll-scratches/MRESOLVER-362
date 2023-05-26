package com.example.mresolver362;

import java.util.List;

import org.eclipse.aether.repository.RemoteRepository;
import org.junit.jupiter.api.Test;

class DependencyResolverTests {

	@Test
	void resolveDependencies() {
		List<RemoteRepository> repositories = List.of(
				DependencyResolver.createRemoteRepository("central", "https://repo1.maven.org/maven2", false),
				DependencyResolver.createRemoteRepository("spring-milestones", "https://repo.spring.io/milestone", false),
				DependencyResolver.createRemoteRepository("spring-snapshots", "https://repo.spring.io/snapshot", true));
		List<BillOfMaterials> boms = List.of(
				new BillOfMaterials("org.springframework.cloud", "spring-cloud-dependencies", "2022.0.3"),
				new BillOfMaterials("org.springframework.boot", "spring-boot-dependencies", "3.0.8-SNAPSHOT"));
		DependencyResolver.resolveDependencies("org.springframework.cloud","spring-cloud-starter-contract-stub-runner", null, boms, repositories);
	}

}
