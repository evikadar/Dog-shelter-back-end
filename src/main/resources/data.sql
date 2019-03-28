-- Shelter

INSERT INTO SHELTER("ID", "NAME")
VALUES (1, 'Big dog home');

INSERT INTO SHELTER("ID", "NAME")
VALUES (2, 'Happy tails');

INSERT INTO SHELTER("ID", "NAME")
VALUES (3, 'Honey home for dogs');


-- Dog descriptions

INSERT INTO DOG_DESCRIPTION("ID", "DREAM_HOME", "PERSONALITY_TRAIT", "SPECIAL_FEATURES")
VALUES (1, 'I like a cool home to be myself with my toys', 'I am funny', 'I had big balls');

INSERT INTO DOG_DESCRIPTION("ID", "DREAM_HOME", "PERSONALITY_TRAIT", "SPECIAL_FEATURES")
VALUES (2, 'Where blue is red', 'long tail', 'Can fly');

INSERT INTO DOG_DESCRIPTION("ID", "DREAM_HOME", "PERSONALITY_TRAIT", "SPECIAL_FEATURES")
VALUES (3, 'Sweet home alabama', 'nice fur', 'Speaks 3 languages');

INSERT INTO DOG_DESCRIPTION("ID", "DREAM_HOME", "PERSONALITY_TRAIT", "SPECIAL_FEATURES")
VALUES (4, 'With a big pool', 'short nails', 'Killer');

INSERT INTO DOG_DESCRIPTION("ID", "DREAM_HOME", "PERSONALITY_TRAIT", "SPECIAL_FEATURES")
VALUES (5, 'Nice boys around', 'nice girl', 'Nothing :(');

INSERT INTO DOG_DESCRIPTION("ID", "DREAM_HOME", "PERSONALITY_TRAIT", "SPECIAL_FEATURES")
VALUES (6, 'Bobababa', 'halala', 'BOOOOOO');


-- Dogs

INSERT INTO DOG("ID", "BREED", "GENDER", "IS_NEUTERED", "NAME", "PHOTO_PATH", "SIZE", "STATUS", "DESCRIPTION_ID",
                "SHELTER_ID")
VALUES (1, 'COLLIE', 'MALE', true, 'Quincy', 'img/dog1.jpeg', 'EXTRA_SMALL', 'AVAILABLE', 1, 1);

INSERT INTO DOG("ID", "BREED", "GENDER", "IS_NEUTERED", "NAME", "PHOTO_PATH", "SIZE", "STATUS", "DESCRIPTION_ID",
                "SHELTER_ID")
VALUES (2, 'MIXED', 'FEMALE', false, 'Gemma', 'img/dog2.jpeg', 'MEDIUM', 'ADOPTED', 2, 2);

INSERT INTO DOG("ID", "BREED", "GENDER", "IS_NEUTERED", "NAME", "PHOTO_PATH", "SIZE", "STATUS", "DESCRIPTION_ID",
                "SHELTER_ID")
VALUES (3, 'CHIHUAHUA', 'MALE', true, 'Bradley', 'img/dog3.jpeg', 'SMALL', 'AVAILABLE', 3, 1);

INSERT INTO DOG("ID", "BREED", "GENDER", "IS_NEUTERED", "NAME", "PHOTO_PATH", "SIZE", "STATUS", "DESCRIPTION_ID",
                "SHELTER_ID")
VALUES (4, 'TERRIER', 'FEMALE', false, 'Karen', 'img/dog4.jpeg', 'LARGE', 'AVAILABLE', 4, 2);

INSERT INTO DOG("ID", "BREED", "GENDER", "IS_NEUTERED", "NAME", "PHOTO_PATH", "SIZE", "STATUS", "DESCRIPTION_ID",
                "SHELTER_ID")
VALUES (5, 'GERMAN_SHEPHERD', 'FEMALE', true, 'Claire', 'img/dog5.jpeg', 'EXTRA_LARGE', 'ADOPTED', 5, 1);

INSERT INTO DOG("ID", "BREED", "GENDER", "IS_NEUTERED", "NAME", "PHOTO_PATH", "SIZE", "STATUS", "DESCRIPTION_ID",
                "SHELTER_ID")
VALUES (6, 'COLLIE', 'MALE', false, 'Bob', 'img/dog6.jpeg', 'LARGE', 'AVAILABLE', 6, 1);