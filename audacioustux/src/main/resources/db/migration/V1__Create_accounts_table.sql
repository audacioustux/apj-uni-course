-- public.accounts definition

-- Drop table

-- DROP TABLE public.accounts;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "citext";
CREATE TABLE public.accounts (
	id uuid NOT NULL DEFAULT uuid_generate_v1mc(),
	username varchar(24) NOT NULL,
	email varchar(255) NOT NULL,
	hashed_password varchar(255) NULL,
	inserted_at timestamp NOT NULL DEFAULT NOW(),
	updated_at timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT accounts_pkey PRIMARY KEY (id)
);
CREATE UNIQUE INDEX accounts_unique_handle_index ON public.accounts USING btree (username);
CREATE UNIQUE INDEX accounts_unique_email_index ON public.accounts USING btree (email);


CREATE OR REPLACE FUNCTION public.trigger_set_updated_at()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
BEGIN
  NEW.updated_at = NOW();
  RETURN NEW;
END;
$function$
;

create trigger set_timestamp before
update
    on
    public.accounts for each row execute function trigger_set_updated_at();
