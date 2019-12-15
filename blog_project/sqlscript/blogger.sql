CREATE DATABASE `blogger`;
USE 'blogger';

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `category` (
  `category_id` bigint(20) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `sub_category` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `blogs` (
  `blog_id` bigint(20) NOT NULL,
  `created_id` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`blog_id`),
  KEY `FKbw5sy2vp4vtpjknu1p77kp2m` (`category_id`),
  KEY `FKbha3gabquv7y88021vn6ccpso` (`user_id`),
  CONSTRAINT `FKbha3gabquv7y88021vn6ccpso` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKbw5sy2vp4vtpjknu1p77kp2m` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `images` (
  `image_id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `blog_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`image_id`),
  KEY `FKanuvl7c3k6aous8ahd059ixk3` (`blog_id`),
  CONSTRAINT `FKanuvl7c3k6aous8ahd059ixk3` FOREIGN KEY (`blog_id`) REFERENCES `blogs` (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `comments` (
  `comment_id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `blog_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK9aakob3a7aghrm94k9kmbrjqd` (`blog_id`),
  KEY `FKqi14bvepnwtjbbaxm7m4v44yg` (`user_id`),
  CONSTRAINT `FK9aakob3a7aghrm94k9kmbrjqd` FOREIGN KEY (`blog_id`) REFERENCES `blogs` (`blog_id`),
  CONSTRAINT `FKqi14bvepnwtjbbaxm7m4v44yg` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `blogs_comments` (
  `Blogs_blog_id` bigint(20) NOT NULL,
  `comments_comment_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_461cymehcepe25oc5kubrx72k` (`comments_comment_id`),
  KEY `FKpjix7n6t4xthb8bwqhwsveilj` (`Blogs_blog_id`),
  CONSTRAINT `FKdxo10ylp58aw8vc7nhg2cjt95` FOREIGN KEY (`comments_comment_id`) REFERENCES `comments` (`comment_id`),
  CONSTRAINT `FKpjix7n6t4xthb8bwqhwsveilj` FOREIGN KEY (`Blogs_blog_id`) REFERENCES `blogs` (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `blogs_images` (
  `Blogs_blog_id` bigint(20) NOT NULL,
  `images_image_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_csdjw4xgo95t6e0h28cjq54kn` (`images_image_id`),
  KEY `FKj5m0x5y8xwvt5fev0jaoysmcb` (`Blogs_blog_id`),
  CONSTRAINT `FKj5m0x5y8xwvt5fev0jaoysmcb` FOREIGN KEY (`Blogs_blog_id`) REFERENCES `blogs` (`blog_id`),
  CONSTRAINT `FKmrxx290jyeqycdsa6somo3yni` FOREIGN KEY (`images_image_id`) REFERENCES `images` (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




