CREATE TABLE logs (
    id uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    log text NOT NULL,
    log_group text,
    level text,
    log_user text,
    created_at timestamp with time zone NOT NULL DEFAULT now()
);