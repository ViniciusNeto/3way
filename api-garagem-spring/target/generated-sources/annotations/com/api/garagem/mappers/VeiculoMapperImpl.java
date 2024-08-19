package com.api.garagem.mappers;

import com.api.garagem.dtos.VeiculoDto;
import com.api.garagem.entities.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-30T20:16:49-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class VeiculoMapperImpl implements VeiculoMapper {

    @Override
    public Veiculo toVeiculo(VeiculoDto veiculoDto) {
        if ( veiculoDto == null ) {
            return null;
        }

        Veiculo veiculo = new Veiculo();

        veiculo.setAnoModelo( veiculoDto.getAnoModelo() );
        veiculo.setCor( veiculoDto.getCor() );
        veiculo.setDescricao( veiculoDto.getDescricao() );
        veiculo.setId( veiculoDto.getId() );
        veiculo.setMarca( veiculoDto.getMarca() );
        veiculo.setModelo( veiculoDto.getModelo() );
        veiculo.setPlaca( veiculoDto.getPlaca() );

        return veiculo;
    }

    @Override
    public VeiculoDto toVeiculoDto(Veiculo veiculo) {
        if ( veiculo == null ) {
            return null;
        }

        VeiculoDto.VeiculoDtoBuilder veiculoDto = VeiculoDto.builder();

        veiculoDto.anoModelo( veiculo.getAnoModelo() );
        veiculoDto.cor( veiculo.getCor() );
        veiculoDto.descricao( veiculo.getDescricao() );
        if ( veiculo.getId() != null ) {
            veiculoDto.id( veiculo.getId() );
        }
        veiculoDto.marca( veiculo.getMarca() );
        veiculoDto.modelo( veiculo.getModelo() );
        veiculoDto.placa( veiculo.getPlaca() );

        return veiculoDto.build();
    }

    @Override
    public List<VeiculoDto> toVeiculoDtos(List<Veiculo> veiculos) {
        if ( veiculos == null ) {
            return null;
        }

        List<VeiculoDto> list = new ArrayList<VeiculoDto>( veiculos.size() );
        for ( Veiculo veiculo : veiculos ) {
            list.add( toVeiculoDto( veiculo ) );
        }

        return list;
    }

    @Override
    public void updateVeiculo(Veiculo target, Veiculo source) {
        if ( source == null ) {
            return;
        }

        target.setAnoModelo( source.getAnoModelo() );
        target.setCor( source.getCor() );
        target.setDescricao( source.getDescricao() );
        target.setId( source.getId() );
        target.setMarca( source.getMarca() );
        target.setModelo( source.getModelo() );
        target.setPlaca( source.getPlaca() );
    }
}
