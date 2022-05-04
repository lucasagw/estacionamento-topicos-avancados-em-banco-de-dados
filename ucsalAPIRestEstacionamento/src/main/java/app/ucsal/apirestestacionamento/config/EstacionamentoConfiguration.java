package app.ucsal.apirestestacionamento.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
import app.ucsal.model.geral.Assinatura;
import app.ucsal.model.geral.Cliente;
import app.ucsal.model.geral.Cor;
import app.ucsal.model.geral.Estacionamento;
import app.ucsal.model.geral.Modelo;
import app.ucsal.model.geral.Ocorrencia;
import app.ucsal.model.geral.OcorrenciaHorista;
import app.ucsal.model.geral.Perfil;
import app.ucsal.model.geral.Preco;
import app.ucsal.model.geral.PrecoTipo;
import app.ucsal.model.geral.Vaga;
import app.ucsal.model.geral.VagaStatus;
import app.ucsal.model.geral.Veiculo;
import app.ucsal.repository.geral.AssinaturaRepository;
import app.ucsal.repository.geral.ClienteCriteriaRepository;
import app.ucsal.repository.geral.ClienteRepository;
import app.ucsal.repository.geral.CorRepository;
import app.ucsal.repository.geral.EstacionamentoRepository;
import app.ucsal.repository.geral.ModeloRepository;
import app.ucsal.repository.geral.OcorrenciaHoristaRepository;
import app.ucsal.repository.geral.OcorrenciaRepository;
import app.ucsal.repository.geral.PerfilRepository;
import app.ucsal.repository.geral.PrecoRepository;
import app.ucsal.repository.geral.PrecoTipoRepository;
import app.ucsal.repository.geral.VagaRepository;
import app.ucsal.repository.geral.VagaStatusRepository;
import app.ucsal.repository.geral.VeiculoRepository;

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
