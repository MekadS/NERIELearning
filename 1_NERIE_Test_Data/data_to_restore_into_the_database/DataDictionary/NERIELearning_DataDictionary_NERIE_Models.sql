-- Get information about tables
SELECT table_catalog, table_schema, column_name, data_type, character_maximum_length, table_name, is_nullable 
	FROM information_schema.columns
	WHERE table_schema = 'nerielearning'
	ORDER BY table_name;	