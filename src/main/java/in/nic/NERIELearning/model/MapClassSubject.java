package in.nic.NERIELearning.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table (name = "map_class_subject")
public class MapClassSubject{
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "mapClassSubjectId", nullable = false, unique = true, length = 5)
	private String mapClassSubjectId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "classId")
	private MClass classId;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "subjectId")
	private MSubject subjectId;
}	