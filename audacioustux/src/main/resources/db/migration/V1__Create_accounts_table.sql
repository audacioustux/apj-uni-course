CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE public.accounts (
	id uuid NOT NULL DEFAULT uuid_generate_v1mc(),
	username varchar(24) NOT NULL,
	ntag varchar(4) NOT NULL,
	hashed_password varchar(255) NULL,
	state varchar(255) NOT NULL,
	inserted_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT accounts_pkey PRIMARY KEY (id)
);
CREATE INDEX accounts_state_index ON public.accounts USING btree (state);
CREATE UNIQUE INDEX accounts_unique_handle_index ON public.accounts USING btree (username, ntag);
