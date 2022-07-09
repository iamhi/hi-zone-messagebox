package com.github.iamhi.hizone.messagebox.out.postgres.adapters;

import com.github.iamhi.hizone.messagebox.out.postgres.UserRepository;
import com.github.iamhi.hizone.messagebox.out.postgres.models.UserEntity;
import com.github.iamhi.hizone.messagebox.outadapter.SecretUserRepositoryAdapter;
import com.github.iamhi.hizone.messagebox.outadapter.models.UserDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public record SecretUserRepositoryAdapterImpl(
    UserRepository userRepository
) implements SecretUserRepositoryAdapter {

    @Override
    public Mono<UserDto> create(UserDto userDto) {
        return userRepository.save(mapToEntity(userDto)).map(this::mapToDto);
    }

    @Override
    public Mono<UserDto> getByUuid(String uuid) {
        return userRepository.findByUuid(uuid).map(this::mapToDto);
    }

    @Override
    public Mono<UserDto> getByUsername(String username) {
        return userRepository.findByUsername(username).map(this::mapToDto);
    }

    @Override
    public Mono<UserDto> getByExternalUuid(String externalUuid) {
        return userRepository.findByExternalUuid(externalUuid).map(this::mapToDto);
    }

    UserDto mapToDto(UserEntity entity) {
        return new UserDto(
            entity.uuid(),
            entity.username(),
            entity.externalUuid(),
            entity.boxUuid(),
            entity.createdAt());
    }

    UserEntity mapToEntity(UserDto dto) {
        return new UserEntity(
            dto.uuid(),
            dto.username(),
            dto.externalUuid(),
            dto.boxUuid(),
            dto.createdAt());
    }
}
