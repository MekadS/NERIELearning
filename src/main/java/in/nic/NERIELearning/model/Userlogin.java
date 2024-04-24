package in.nic.NERIELearning.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import in.nic.NERIELearning.config.ConstantUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
//@AllArgsConstructor
@Table(name = "t_userlogin")
public class Userlogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userLoginId;

	@NotBlank
	@NotEmpty
	@Pattern(regexp = ConstantUtils.REGEXP_USERNAME, message = "Invalid Username")
	@Column(length = 50, nullable = false, unique = true)
	private String username;

	@NotBlank
	@NotEmpty
	@Column(length = 100, nullable = false)
	private String password;

	@OneToOne()
	@JoinColumn(name = "roleId")
	public MRole role;

	@Column(length = 1, nullable = false)
	private Boolean isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "entrydate", nullable = false)
	private Date entrydate;

	@Transient
	private String captcha;

	@Transient
	private String hiddenCaptcha;

	@Transient
	private String realCaptcha;

	public Userlogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Userlogin(Long userLoginId,
			@NotBlank @NotEmpty @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Invalid Username") String username,
			@NotBlank @NotEmpty String password, MRole role, Boolean isActive, Date entrydate, String captcha,
			String hiddenCaptcha, String realCaptcha) {
		super();
		this.userLoginId = userLoginId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
		this.entrydate = entrydate;
		this.captcha = captcha;
		this.hiddenCaptcha = hiddenCaptcha;
		this.realCaptcha = realCaptcha;
	}
}
