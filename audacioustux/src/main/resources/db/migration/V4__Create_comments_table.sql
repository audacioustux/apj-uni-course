-- public.comments definition

-- Drop table

-- DROP TABLE public.comments;

CREATE TABLE public.comments (
	id uuid NOT NULL DEFAULT uuid_generate_v1mc(),
	body text NOT NULL,
	blog_id uuid NOT NULL,
    account_id uuid NOT NULL,
	replied_to_id uuid NULL,
	inserted_at timestamp NOT NULL DEFAULT NOW(),
	updated_at timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT blog_comments_pkey PRIMARY KEY (id, blog_id)
);
CREATE INDEX blog_comments_blog_id_index ON public.comments USING btree (blog_id);
CREATE INDEX blog_comments_parent_id_index ON public.comments USING btree (replied_to_id);
CREATE INDEX blog_comments_account_id_index ON public.comments USING btree (account_id);


-- public.comments foreign keys

ALTER TABLE public.comments ADD CONSTRAINT blog_comments_blog_id_fkey FOREIGN KEY (blog_id) REFERENCES public.blogs(id) ON DELETE CASCADE;
ALTER TABLE public.comments ADD CONSTRAINT blog_comments_parent_id_fkey FOREIGN KEY (replied_to_id,blog_id) REFERENCES public.comments(id,blog_id) ON DELETE CASCADE;
ALTER TABLE public.comments ADD CONSTRAINT blog_comments_account_id_fkey FOREIGN KEY (account_id) REFERENCES public.accounts(id) ON DELETE CASCADE;


create trigger set_timestamp before
update
    on
    public.comments for each row execute function trigger_set_updated_at();
