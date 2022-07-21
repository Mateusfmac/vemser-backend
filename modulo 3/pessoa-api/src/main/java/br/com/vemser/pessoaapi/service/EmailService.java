package br.com.vemser.pessoaapi.service;


import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Service
public class EmailService {
    
    private final freemarker.template.Configuration fmConfiguration;
    
    @Value("${spring.mail.username}")
    private String from;
    
    private final JavaMailSender emailSender;
    
    //exercicio 1
    public void createSimpleMessagePessoa(Pessoa pessoa) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(pessoa.getEmail());
        message.setSubject("Assunto teste exercicio aula");
        message.setText("Olá " + pessoa.getNome() +
                "\nEstamos felizes em ter voce em nosso sistema :) " +
                "\nSeu cadastro foi realizado com sucesso, seu identificador é: " + pessoa.getIdPessoa() +
                "\nQualquer duvida é so contatar o suporte pelo email " + from +
                "\nAtt, " +
                "\nSistema.");
        emailSender.send(message);
    }
    
    //exercicio2
    public void updateSimpleMessagePessoa(Pessoa pessoa) {
        SimpleMailMessage emailMessage = new SimpleMailMessage();
        emailMessage.setFrom(from);
        emailMessage.setTo(pessoa.getEmail());
        emailMessage.setSubject("Alteracao de dados");
        emailMessage.setText("Olá " + pessoa.getNome() +
                "\nSeus dados foram atualizados em nosso sistema. " +
                "\nQualquer duvida é so contatar o suporte pelo email " + from +
                "\nAtt, " +
                "\nSistema.");
    }
    
    //homework
    public String getTemplateCreate(PessoaDTO pessoa, EnderecoDTO endereco) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("email", pessoa.getEmail());
        dados.put("idEndereco", endereco.getIdEndereco());
        dados.put("from", from);
        Template template = fmConfiguration.getTemplate("email-templateCreate.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
    
    public String getTemplateUpdate(PessoaDTO pessoa, EnderecoDTO endereco) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("email", pessoa.getEmail());
        dados.put("idEndereco", endereco.getIdEndereco());
        dados.put("from", from);
        Template template = fmConfiguration.getTemplate("email-templateDelete.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
    
    public String getTemplateDelete(Pessoa pessoa, Endereco endereco) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("email", pessoa.getEmail());
        dados.put("idEndereco", endereco.getIdEndereco());
        dados.put("from", from);
        Template template = fmConfiguration.getTemplate("email-templateDelete.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
    
    public void sendEmailCreate(PessoaDTO pessoa, EnderecoDTO endereco) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            FileSystemResource image1 = new FileSystemResource(new File("C:\\DBC\\vemser-backend\\modulo 3\\pessoa-api\\src\\main\\resources\\templates\\images\\img1.png"));
            FileSystemResource image2 = new FileSystemResource(new File("C:\\DBC\\vemser-backend\\modulo 3\\pessoa-api\\src\\main\\resources\\templates\\images\\img2.png"));
            FileSystemResource image3 = new FileSystemResource(new File("C:\\DBC\\vemser-backend\\modulo 3\\pessoa-api\\src\\main\\resources\\templates\\images\\Reservei.png"));
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("Endereço Criado");
            mimeMessageHelper.addInline("image1.png", image1);
            mimeMessageHelper.addInline("image2.png", image2);
            mimeMessageHelper.addInline("image3.png", image3);
            mimeMessageHelper.addInline("image3.png", image3);
            mimeMessageHelper.setText(getTemplateCreate(pessoa, endereco), true);
            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
    
    public void sendEmailUpdate(PessoaDTO pessoa, EnderecoDTO endereco) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("Endereço Atualizado");
            mimeMessageHelper.setText(getTemplateUpdate(pessoa, endereco), true);
            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
    
    public void sendEmailDelete(Pessoa pessoa, Endereco endereco) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("Endereço Deletado");
            mimeMessageHelper.setText(getTemplateDelete(pessoa, endereco), true);
            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
