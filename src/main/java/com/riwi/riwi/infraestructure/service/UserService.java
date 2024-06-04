package com.riwi.riwi.infraestructure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.riwi.api.dto.request.UserReq;
import com.riwi.riwi.api.dto.response.SurveyRespToUserResp;
import com.riwi.riwi.api.dto.response.UserResp;
import com.riwi.riwi.domain.entities.SurveyEntity;
import com.riwi.riwi.domain.entities.UserEntity;
import com.riwi.riwi.domain.repositories.UserRepository;
import com.riwi.riwi.infraestructure.abstract_services.IUserService;
import com.riwi.riwi.util.enums.SortType;
import com.riwi.riwi.util.exception.BadRequestException;
import com.riwi.riwi.util.messages.ErrorMessages;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    // Crea metodo publico para crear
    public UserResp create(UserReq survey) {

        // Se llama al metodo que convierte la resquest en respuesta
        // y al metodo que busca por id para saber cual se va listar
        UserEntity entity = this.requestToEntity(survey);
        entity.setSurvey(new ArrayList<>());
        return this.entityToResponse(this.userRepository.save(entity));
    }

    // Metodo para listar por ID
    @Override
    public UserResp get(Long id) {
        // Se llama al metodo que convierte la entidad en respuesta
        // y al metodo que busca por id para saber cual se va listar
        return this.entityToResponse(this.find(id));
    }

    @Override
    public UserResp update(UserReq survey, Long id) {

        UserEntity user = this.find(id);

        UserEntity userUpdate = this.requestToEntity(survey);
        userUpdate.setId(user.getId());
        userUpdate.setSurvey(user.getSurvey());

        return this.entityToResponse(this.userRepository.save(userUpdate));
    }

    @Override
    public void delete(Long id) {
        UserEntity user = this.find(id);
        this.userRepository.delete(user);

    }

    @Override
    public Page<UserResp> getAll(int page, int size, SortType sortType) {

        if (page < 0)
            page = 0;

        PageRequest pagination = null;
        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.userRepository.findAll(pagination).map(this::entityToResponse);
    }

    private UserResp entityToResponse(UserEntity entity) {


        return UserResp.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .active(entity.getName())
                .build();

    }


    private UserEntity requestToEntity(UserReq request) {
        List<SurveyEntity> list = new ArrayList<>();
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(request, entity);
        entity.setSurvey(list);

        return entity;
    }

    private UserEntity find(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("usuario")));
    }

}
