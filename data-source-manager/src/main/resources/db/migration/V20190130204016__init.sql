CREATE TABLE source (
  -- General info
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  dialect VARCHAR(255),
  -- Connection details
  connection_string VARCHAR(1024),
  username VARCHAR(255),
  password VARCHAR(255),
  -- Kerberos params
  use_kerberos BOOLEAN,
  krb_auth_method VARCHAR(255),
  krb_realm VARCHAR(255),
  krb_fqdn VARCHAR(255),
  krb_user VARCHAR(255),
  krb_password VARCHAR(255),
  krb_keytab BYTEA,
  -- CDM schemas
  cdm_schema VARCHAR(255),
  vocab_schema VARCHAR(255),
  result_schema VARCHAR(255),
  temp_schema VARCHAR(255),
  cem_schema VARCHAR(255),
  cem_results_schema VARCHAR(255),
  -- Metadata
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  deleted_at VARCHAR(255)
)