CREATE TABLE topic (
                        id uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
                        title text NOT NULL,
                        description text NOT NULL,
                        author text NOT NULL,
                        visible boolean NOT NULL DEFAULT true,
                        created_at timestamp with time zone NOT NULL DEFAULT now(),
                        updated_at timestamp with time zone NULL DEFAULT now()
);

CREATE TABLE comment (
                          id uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
                          comment_text text NOT NULL,
                          author text NOT NULL,
                          visible boolean NOT NULL DEFAULT true,
                          topic_id uuid NOT NULL,
                          created_at timestamp with time zone NOT NULL DEFAULT now(),
                          updated_at timestamp with time zone NOT NULL DEFAULT now(),
                          FOREIGN KEY (topic_id) REFERENCES topic (id) ON DELETE CASCADE
);