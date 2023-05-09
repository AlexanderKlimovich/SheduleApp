package com.klymovych.university.services.implementsAll;

import com.klymovych.university.model.Group;
import com.klymovych.university.repositories.GroupRepository;
import com.klymovych.university.services.GroupService;
import com.klymovych.university.services.ServiceException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(int id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Group not found with id: " + id));
    }

    @Override
    public Group save(@Valid Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group update(@Valid Group group) {
        Group existingGroup = groupRepository.findById(group.getId())
                .orElseThrow(() -> new ServiceException("Group not found with id: " + group.getId()));
        existingGroup.setName(group.getName());
        existingGroup.setStudents(group.getStudents());
        existingGroup.setStatus(group.getStatus());
        return groupRepository.save(existingGroup);
    }

    @Override
    public void deleteById(int id) {
        if (!groupRepository.existsById(id)) {
            throw new ServiceException("Group not found with id: " + id);
        }
        groupRepository.deleteById(id);
    }
}
