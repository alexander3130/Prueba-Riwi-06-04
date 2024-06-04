package com.riwi.riwi.api.controller;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.riwi.api.dto.request.UserReq;
import com.riwi.riwi.api.dto.response.UserResp;
import com.riwi.riwi.infraestructure.abstract_services.IUserService;
import com.riwi.riwi.util.enums.SortType;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping(path = "/users")
@AllArgsConstructor

@Tag(name = "Usuarios")
public class UserController {
    private final IUserService userService;

    // anotacion para obtener
    @GetMapping
    public ResponseEntity<Page<UserResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "1000") int size,
            @RequestHeader(required = false) SortType sortType) {

        if (Objects.isNull(sortType))
            sortType = SortType.NONE;

        // Se llama al servicio donde esta el metodo para listar todo y se retorna todos
        // los valores obtenidos
        return ResponseEntity.ok(this.userService.getAll(page - 1, size, sortType));

    }

    // anotacion para obtener por ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResp> getById(
            @PathVariable("id") Long id) {
        // Se llama al servicio donde esta el metodo para obtener y se reporta el valor
        // obtenido
        return ResponseEntity.ok(this.userService.get(id));
    }

    // anotacion para recibir informacion
    @PostMapping
    public ResponseEntity<UserResp> insert(
            @Validated @RequestBody UserReq request) {
        // Se llama al servicio donde esta el metodo para crear y se reporta el valor
        // obtenido
        return ResponseEntity.ok(userService.create(request));
    }

    // anotacion para actualizar informacion por ID
    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResp> update(
            @Validated @RequestBody UserReq resquest,
            @PathVariable("id") Long id) {
        // Se llama al servicio donde esta el metodo para actualizar y se reporta el valor
        // obtenido
        return ResponseEntity.ok(userService.update(resquest, id));
    }

    // eliminar por ID
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        // Se llama al servicio donde esta el metodo para eliminar
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
