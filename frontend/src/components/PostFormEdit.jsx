import { useState } from "react";
import { useDisclosure } from '@mantine/hooks';
import { useNavigate } from "react-router-dom";
import { Modal, Button, Textarea, Stack, ActionIcon } from "@mantine/core";
import { IconEdit } from "@tabler/icons-react";
import { fetchUpdatePost, usePostWithId } from "../util/hooks";

function PostFormEdit({ postId }) {
    const [data, error] = usePostWithId(postId);
    const navigate = useNavigate();
    const [opened, {open, close}] = useDisclosure(false); 
    const [input, setInput] = useState("");
  
    const handleClick = (event) => {
        event.preventDefault();
        fetchCreatePost(input);
        setInput("");
        navigate(0);
        close();
    };
  
    if (error || data == null) return null;
    return (
      <>
        <ActionIcon
            variant="subtle"
            color="gray"
            onClick={() => {
                setInput(data.textContent);
                open();
            }}
            size="lg"
        >
            <IconEdit size={20} />
        </ActionIcon>
        <Modal
          opened={opened}
          onClose={close}
          title="New Post"
        >
            <Stack>
                <Textarea 
                    label="Post"
                    placeholder="Edit your post"
                    autosize
                    minRows={4}
                    maxRows={6}
                    value={input}
                    onChange={(event) => setInput(event.currentTarget.value)}
                />
                <Button onClick={handleClick}>
                    Send
                </Button>
            </Stack>
        </Modal>
      </>
    );
  };
  
  export default PostFormEdit;