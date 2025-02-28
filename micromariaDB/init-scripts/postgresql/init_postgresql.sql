-- Crear base de datos y tabla para PostgreSQL
DO $$
BEGIN
   IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'auto_db') THEN
      PERFORM pg_catalog.create_database('auto_db');
END IF;
END $$;
\c auto_db;

CREATE TABLE Auto (
                                    auto_id SERIAL PRIMARY KEY,
                                    auto_marca VARCHAR(100),
    auto_modelo VARCHAR(100),
    auto_anio VARCHAR(4)
    );

-- Habilitar replicación lógica
CREATE ROLE debezium WITH REPLICATION LOGIN PASSWORD 'debezium_password';
ALTER SYSTEM SET wal_level = 'logical';
ALTER SYSTEM SET max_replication_slots = 4;
ALTER SYSTEM SET max_wal_senders = 4;

-- Crear publicación para replicación lógica
CREATE PUBLICATION auto_publication FOR TABLE auto;

-- Recargar configuración
SELECT pg_reload_conf();
