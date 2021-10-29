-- public.sessions definition

-- Drop table

-- DROP TABLE public.sessions;

CREATE TABLE public.sessions (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	is_deleted bool NOT NULL DEFAULT false,
	account_id uuid NOT NULL,
	inserted_at timestamp NOT NULL DEFAULT NOW(),
	updated_at timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT sessions_pkey PRIMARY KEY (id)
);
CREATE INDEX sessions_account_id_index ON public.sessions USING btree (account_id);


-- public.sessions foreign keys

ALTER TABLE public.sessions ADD CONSTRAINT sessions_account_id_fkey FOREIGN KEY (account_id) REFERENCES public.accounts(id) ON DELETE CASCADE;


create trigger set_timestamp before
update
    on
    public.sessions for each row execute function trigger_set_updated_at();
