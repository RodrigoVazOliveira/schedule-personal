CREATE TABLE markings (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   owner_id BIGINT,
   name VARCHAR(400) NOT NULL,
   description VARCHAR(400) NOT NULL,
   date_time_invite_initial TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   date_time_invite_final TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   date_time_created TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   date_time_updated TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   CONSTRAINT pk_markings PRIMARY KEY (id),
   CONSTRAINT FK_MARKINGS_ON_OWNER FOREIGN KEY (owner_id) REFERENCES owners (id)
);

CREATE TABLE markings_invites (
    marking_entity_id BIGINT NOT NULL,
    invites_id BIGINT NOT NULL,
    CONSTRAINT uc_markings_invites_invites UNIQUE (invites_id),
    CONSTRAINT fk_marinv_on_owner_entity FOREIGN KEY (invites_id) REFERENCES owners (id),
    CONSTRAINT fk_marinv_on_marking_entity FOREIGN KEY (marking_entity_id) REFERENCES markings (id)
);