package com.projetPersos.ADM.transformator;

import com.projetPersos.ADM.repository.dao.Table;
import com.projetPersos.ADM.ui.dto.TableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TableTransformator {
    @Autowired
    MemberTransformator memberTransformator;

    public TableDTO modelToDto(Table table){
        if(table==null){
            return null;
        }
        return new TableDTO(table.getId(), table.getName(), table.getDate(), memberTransformator.modelToDto(table.getMember()));
    }

    public List<TableDTO> modelsToDtos(List<Table> tables){
        return tables.stream().map(this::modelToDto).collect(Collectors.toList());
    }

    public Table dtoToModel(TableDTO tableDTO){
        if(tableDTO==null){
            return null;
        }
        return new Table(tableDTO.getId(), tableDTO.getName(), tableDTO.getDate(), memberTransformator.dtoToModel(tableDTO.getMemberDTO()),null);
    }

    public List<Table> dtosToModels(List<TableDTO> tableDTOS){
        return tableDTOS.stream().map(this::dtoToModel).collect(Collectors.toList());
    }
}
