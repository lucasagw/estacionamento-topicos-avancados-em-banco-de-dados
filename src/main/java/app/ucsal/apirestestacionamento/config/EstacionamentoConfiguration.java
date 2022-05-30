package app.ucsal.apirestestacionamento.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import app.ucsal.apirestestacionamento.model.Assinatura;
import app.ucsal.apirestestacionamento.model.Cliente;
import app.ucsal.apirestestacionamento.model.Cor;
import app.ucsal.apirestestacionamento.model.Estacionamento;
import app.ucsal.apirestestacionamento.model.Modelo;
import app.ucsal.apirestestacionamento.model.Ocorrencia;
import app.ucsal.apirestestacionamento.model.OcorrenciaHorista;
import app.ucsal.apirestestacionamento.model.Perfil;
import app.ucsal.apirestestacionamento.model.Preco;
import app.ucsal.apirestestacionamento.model.PrecoTipo;
import app.ucsal.apirestestacionamento.model.Vaga;
import app.ucsal.apirestestacionamento.model.VagaStatus;
import app.ucsal.apirestestacionamento.model.Veiculo;
import app.ucsal.apirestestacionamento.repository.AssinaturaRepository;
import app.ucsal.apirestestacionamento.repository.ClienteCriteriaRepository;
import app.ucsal.apirestestacionamento.repository.ClienteRepository;
import app.ucsal.apirestestacionamento.repository.CorRepository;
import app.ucsal.apirestestacionamento.repository.EstacionamentoRepository;
import app.ucsal.apirestestacionamento.repository.ModeloRepository;
import app.ucsal.apirestestacionamento.repository.OcorrenciaHoristaRepository;
import app.ucsal.apirestestacionamento.repository.OcorrenciaRepository;
import app.ucsal.apirestestacionamento.repository.PerfilRepository;
import app.ucsal.apirestestacionamento.repository.PrecoRepository;
import app.ucsal.apirestestacionamento.repository.PrecoTipoRepository;
import app.ucsal.apirestestacionamento.repository.VagaRepository;
import app.ucsal.apirestestacionamento.repository.VagaStatusRepository;
import app.ucsal.apirestestacionamento.repository.VeiculoRepository;
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
