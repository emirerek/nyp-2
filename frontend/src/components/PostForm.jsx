import { useState } from "react";
import { useDisclosure } from '@mantine/hooks';
import { useNavigate } from "react-router-dom";
import { Modal, Button, Textarea, Stack } from "@mantine/core";
import { IconWriting } from "@tabler/icons-react";
import { fetchCreatePost } from "../util/hooks";

function PostForm() {
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
  
    return (
      <>
        <Button 
            w="100%" 
            leftSection={<IconWriting size={20} />}
            onClick={open}
        >
            New Post
        </Button>
        <Modal
          opened={opened}
          onClose={close}
          title="New Post"
        >
            <Stack>
                <Textarea 
                    label="Post"
                    placeholder="Write your post"
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
  
  export default PostForm;
  