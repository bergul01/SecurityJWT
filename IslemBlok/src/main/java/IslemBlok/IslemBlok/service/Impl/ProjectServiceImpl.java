package IslemBlok.IslemBlok.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IslemBlok.IslemBlok.entity.Project;
import IslemBlok.IslemBlok.exception.ResourceNotFoundException;
import IslemBlok.IslemBlok.repository.ProjectRepository;
import IslemBlok.IslemBlok.service.ProjectService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private final ProjectRepository projectRepository;
	
	@Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

	@Override public Project updateProject(Long id, Project projectDetails) {
		Project project = projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
		project.setName(projectDetails.getName());
		project.setDescription(projectDetails.getDescription());
		
		return projectRepository.save(project);
		
	}
	
    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
    }

    @Override
    public List<Project> getProjectsByUserId(Long userId) {
        return projectRepository.findByUserId(userId);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
	
}
