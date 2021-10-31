-- public.blogs definition

-- Drop table

-- DROP TABLE public.blogs;

CREATE TABLE public.blogs (
	id uuid NOT NULL DEFAULT uuid_generate_v1mc(),
	title varchar(255) NOT NULL,
	body text NOT NULL,
	account_id uuid NOT NULL,
	inserted_at timestamp NOT NULL DEFAULT NOW(),
	updated_at timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT blogs_pkey PRIMARY KEY (id)
);
CREATE INDEX blogs_account_id_index ON public.blogs USING btree (account_id);


-- public.blogs foreign keys

ALTER TABLE public.blogs ADD CONSTRAINT blogs_profile_id_fkey FOREIGN KEY (account_id) REFERENCES public.accounts(id) ON DELETE CASCADE;


create trigger set_timestamp before
update
    on
    public.blogs for each row execute function trigger_set_updated_at();
