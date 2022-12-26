       // Set the following constants to your OpenTok API key and API secret.
        // See https://tokbox.com/account/.
        OpenTok opentok = new OpenTok(47632071, "0b962007058492c7a13d096cad18621c461dad14");

        //Generate a basic session. Or you could use an existing session ID.
        String sessionId = opentok.createSession().getSessionId();

        // Replace with meaningful metadata for the connection.
        String connectionMetadata = "username=Bob,userLevel=4";

        // Generate a token. Use the Role value appropriate for the user.
        TokenOptions tokenOpts = new TokenOptions.Builder()
          .role(Role.MODERATOR)
          .expireTime((System.currentTimeMillis() / 1000) + (7 * 24 * 60 * 60)) // in one week
          .data(connectionMetadata)
          .build());
        String token = opentok.generateToken(sessionId, tokenOpts);
        System.out.println(token);