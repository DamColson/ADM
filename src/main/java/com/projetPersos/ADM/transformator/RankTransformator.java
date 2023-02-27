package com.projetPersos.ADM.transformator;

import com.projetPersos.ADM.repository.dao.Rank;
import com.projetPersos.ADM.ui.dto.RankDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RankTransformator {
    public RankDTO modelToDto(final Rank rank){
        if(rank==null){
            return null;
        }
        return new RankDTO(rank.getId(),rank.getName());
    }

    public List<RankDTO> modelsToDtos(final List<Rank> ranks){
        return ranks.stream().map(this::modelToDto).collect(Collectors.toList());
    }

    public Rank dtoToModel(final RankDTO rankDto){
        if(rankDto==null){
            return null;
        }
        return new Rank(rankDto.getId(),rankDto.getName(),null);
    }

    public List<Rank> dtosToModels(final List<RankDTO> rankDtos){
        return rankDtos.stream().map(this::dtoToModel).collect(Collectors.toList());
    }
}
