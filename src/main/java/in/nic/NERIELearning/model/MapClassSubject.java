package in.nic.NERIELearning.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "map_class_subject")
public class MapClassSubject{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "map_class_subject_id_seq")
	@SequenceGenerator(name = "map_class_subject_id_seq", sequenceName = "M_CLASS_SEQ", allocationSize = 50, initialValue = 100)
	private Long mapClassSubjectId;

	@Builder.Default
	@Column(length = 1, nullable = false)
	private Boolean isActive = true;
	
	@ManyToOne
	@JoinColumn(name = "mClassId")
	private MClass mClassId;
	
	@ManyToOne
	@JoinColumn(name = "mSubjectId")
	private MSubject mSubjectId;
}