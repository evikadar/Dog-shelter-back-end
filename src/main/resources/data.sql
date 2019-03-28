INSERT INTO PUBLIC.ADDRESS (ID, ADDRESS, CITY, COUNTRY, ZIP_CODE) VALUES (1, 'Váci St. 100.', 'Budapest', 'Hungary', 1130);
INSERT INTO PUBLIC.DOG (ID, BREED, GENDER, IS_NEUTERED, NAME, PHOTO_PATH, SIZE, STATUS, DESCRIPTION_ID, SHELTER_ID, COLOUR) VALUES (1, 'COLLIE', 'MALE', true, 'Quincy', 'img/dog1.jpeg', 'EXTRA_SMALL', 'AVAILABLE', 1, 1, null);
INSERT INTO PUBLIC.DOG (ID, BREED, GENDER, IS_NEUTERED, NAME, PHOTO_PATH, SIZE, STATUS, DESCRIPTION_ID, SHELTER_ID, COLOUR) VALUES (2, 'MIXED', 'FEMALE', false, 'Gemma', 'img/dog2.jpeg', 'MEDIUM', 'ADOPTED', 2, 2, null);
INSERT INTO PUBLIC.DOG (ID, BREED, GENDER, IS_NEUTERED, NAME, PHOTO_PATH, SIZE, STATUS, DESCRIPTION_ID, SHELTER_ID, COLOUR) VALUES (3, 'CHIHUAHUA', 'MALE', true, 'Bradley', 'img/dog3.jpeg', 'SMALL', 'AVAILABLE', 3, 1, null);
INSERT INTO PUBLIC.DOG (ID, BREED, GENDER, IS_NEUTERED, NAME, PHOTO_PATH, SIZE, STATUS, DESCRIPTION_ID, SHELTER_ID, COLOUR) VALUES (4, 'TERRIER', 'FEMALE', false, 'Karen', 'img/dog4.jpeg', 'LARGE', 'AVAILABLE', 4, 2, null);
INSERT INTO PUBLIC.DOG (ID, BREED, GENDER, IS_NEUTERED, NAME, PHOTO_PATH, SIZE, STATUS, DESCRIPTION_ID, SHELTER_ID, COLOUR) VALUES (5, 'GERMAN_SHEPHERD', 'FEMALE', true, 'Claire', 'img/dog5.jpeg', 'EXTRA_LARGE', 'ADOPTED', 5, 1, null);
INSERT INTO PUBLIC.DOG_DESCRIPTION (ID, DREAM_HOME, PERSONALITY_TRAIT, SPECIAL_FEATURES) VALUES (1, 'I like a cool home to be myself with my toys', 'I am funny', 'I had big balls');
INSERT INTO PUBLIC.DOG_DESCRIPTION (ID, DREAM_HOME, PERSONALITY_TRAIT, SPECIAL_FEATURES) VALUES (2, 'Where blue is red', 'long tail', 'Can fly');
INSERT INTO PUBLIC.DOG_DESCRIPTION (ID, DREAM_HOME, PERSONALITY_TRAIT, SPECIAL_FEATURES) VALUES (3, 'Sweet home alabama', 'nice fur', 'Speaks 3 languages');
INSERT INTO PUBLIC.DOG_DESCRIPTION (ID, DREAM_HOME, PERSONALITY_TRAIT, SPECIAL_FEATURES) VALUES (4, 'With a big pool', 'short nails', 'Killer');
INSERT INTO PUBLIC.DOG_DESCRIPTION (ID, DREAM_HOME, PERSONALITY_TRAIT, SPECIAL_FEATURES) VALUES (5, 'Nice boys around', 'nice girl', 'Nothing :(');
INSERT INTO PUBLIC.SHELTER (ID, NAME, EMAIL, PHONE_NUMBER, PHOTO_PATH, SHELTER_DESCRIPTION, ADDRESS_ID) VALUES (2, 'Happy tails', 'happy.tails@animals.org', null, null, null, null);
INSERT INTO PUBLIC.SHELTER (ID, NAME, EMAIL, PHONE_NUMBER, PHOTO_PATH, SHELTER_DESCRIPTION, ADDRESS_ID) VALUES (1, 'Big dog home', 'big.dog.home@animals.org', null, null, null, 1);
INSERT INTO PUBLIC.SHELTER (ID, NAME, EMAIL, PHONE_NUMBER, PHOTO_PATH, SHELTER_DESCRIPTION, ADDRESS_ID) VALUES (3, 'Honey home for dogs', 'honey.home.for.dogs@animals.org', null, null, null, null);