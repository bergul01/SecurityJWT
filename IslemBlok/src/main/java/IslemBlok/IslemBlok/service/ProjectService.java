package IslemBlok.IslemBlok.service;

import java.util.List;

import IslemBlok.IslemBlok.entity.Project;

public interface ProjectService {

	Project saveProject(Project project);
	
	Project updateProject(Long id, Project projectDetails);

    Project getProjectById(Long id);

    List<Project> getProjectsByUserId(Long userId);

    void deleteProject(Long id);
}
