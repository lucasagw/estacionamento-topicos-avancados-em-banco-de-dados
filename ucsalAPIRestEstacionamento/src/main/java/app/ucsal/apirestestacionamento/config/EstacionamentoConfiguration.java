package app.ucsal.apirestestacionamento.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import app.ucsal.apirestestacionamento.model.geral.Assinatura;
import app.ucsal.apirestestacionamento.model.geral.Cliente;
import app.ucsal.apirestestacionamento.model.geral.Cor;
import app.ucsal.apirestestacionamento.model.geral.Estacionamento;
import app.ucsal.apirestestacionamento.model.geral.Modelo;
import app.ucsal.apirestestacionamento.model.geral.Ocorrencia;
import app.ucsal.apirestestacionamento.model.geral.OcorrenciaHorista;
import app.ucsal.apirestestacionamento.model.geral.Perfil;
import app.ucsal.apirestestacionamento.model.geral.Preco;
import app.ucsal.apirestestacionamento.model.geral.PrecoTipo;
import app.ucsal.apirestestacionamento.model.geral.Vaga;
import app.ucsal.apirestestacionamento.model.geral.VagaStatus;
import app.ucsal.apirestestacionamento.model.geral.Veiculo;
import app.ucsal.apirestestacionamento.repository.geral.AssinaturaRepository;
import app.ucsal.apirestestacionamento.repository.geral.ClienteCriteriaRepository;
import app.ucsal.apirestestacionamento.repository.geral.ClienteRepository;
import app.ucsal.apirestestacionamento.repository.geral.CorRepository;
import app.ucsal.apirestestacionamento.repository.geral.EstacionamentoRepository;
import app.ucsal.apirestestacionamento.repository.geral.ModeloRepository;
import app.ucsal.apirestestacionamento.repository.geral.OcorrenciaHoristaRepository;
import app.ucsal.apirestestacionamento.repository.geral.OcorrenciaRepository;
import app.ucsal.apirestestacionamento.repository.geral.PerfilRepository;
import app.ucsal.apirestestacionamento.repository.geral.PrecoRepository;
import app.ucsal.apirestestacionamento.repository.geral.PrecoTipoRepository;
import app.ucsal.apirestestacionamento.repository.geral.VagaRepository;
import app.ucsal.apirestestacionamento.repository.geral.VagaStatusRepository;
import app.ucsal.apirestestacionamento.repository.geral.VeiculoRepository;
import app.ucsal.apirestestacionamento.service.AssinaturaService;
import app.ucsal.apirestestacionamento.service.ClienteService;
import app.ucsal.apirestestacionamento.service.CorService;
import app.ucsal.apirestestacionamento.service.EstacionamentoService;
import app.ucsal.apirestestacionamento.service.ModeloService;
import app.ucsal.apirestestacionamento.service.OcorrenciaService;
import app.ucsal.apirestestacionamento.service.PerfilService;
import app.ucsal.apirestestacionamento.service.PrecoService;
import app.ucsal.apirestestacionamento.service.VagaService;
import app.ucsal.apirestestacionamento.service.VeiculoService;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {
		AssinaturaRepository.class,
		ClienteRepository.class,
		CorRepository.class,
		EstacionamentoRepository.class,
		ModeloRepository.class,
		OcorrenciaRepository.class,
		OcorrenciaHoristaRepository.class,
		PerfilRepository.class,
		PrecoRepository.class,
		PrecoTipoRepository.class,
		VagaRepository.class,
		VagaStatusRepository.class,
		VeiculoRepository.class
		
})
@EntityScan(basePackageClasses = {
		Assinatura.class,
		Cliente.class,
		Cor.class,
		Estacionamento.class,
		Modelo.class,
		Ocorrencia.class,
		OcorrenciaHorista.class,
		Perfil.class,
		Preco.class,
		PrecoTipo.class,
		Vaga.class,
		VagaStatus.class,
		Veiculo.class		
})
@ComponentScan(basePackageClasses = {
		AssinaturaService.class,
		ClienteService.class,
		CorService.class,
		EstacionamentoService.class,
		ModeloService.class,
		OcorrenciaService.class,
		PerfilService.class,
		PrecoService.class,
		VagaService.class,
		VeiculoService.class,
		ClienteCriteriaRepository.class
		
})
public class EstacionamentoConfiguration {

}
