SELECT * FROM nerielearning.m_class cl 
	JOIN nerielearning.map_class_subject mp
	ON cl.class_id = mp.class_id
	JOIN nerielearning.m_subject sj
	ON mp.subject_id = sj.subject_id
	WHERE mp.class_id = @param;